package com.spring.app.models.dao;

import java.io.IOException;
import java.util.Map;

public interface ProjectRepository {
	public String findNameProyectById(String id) throws IOException;
}
