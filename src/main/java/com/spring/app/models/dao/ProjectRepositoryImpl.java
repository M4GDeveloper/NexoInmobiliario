package com.spring.app.models.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.app.models.entity.ProjectNexo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	
	private Logger log = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

	private Gson formatJSON = new Gson();

	@Override
	public String findNameProyectById(String id) throws IOException {
		// FIND PROJECT  BY ID;
		List<ProjectNexo> projectsNexo = listAllProjects();
//		System.out.println(id);
		Map<String,Object> response = new HashMap<>();
		ProjectNexo projectNexo = projectsNexo.stream()
										.filter(nexo -> id.equals(nexo.getId().toString()))
										.findAny()
										.orElse(null);
		if (projectNexo != null) {
			String nameProject = projectNexo.getName();
			return nameProject;
		}
		return null;
	}
	
	private List<ProjectNexo> listAllProjects() throws IOException{
		
		List<ProjectNexo> response_projects = new ArrayList<>();
		
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://api.nexoinmobiliario.pe/v1/projects")
				  .method("GET", null)
				  .addHeader("Authorization", "Bearer 94a3f11e9612456193c7ef26f4b46676")
				  .build();
				Response response = client.newCall(request).execute();
				String response_string =  response.body().string();
				response_projects = formatJSON.fromJson(response_string, new TypeToken<List<ProjectNexo>>(){}.getType());
				System.out.println(response_projects.toString());
		return response_projects;
	}

}
