package com.spring.app.models.entity;

public class ProjectNexo {
	private Integer id;
	private String name;
	private String slug;

	public ProjectNexo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "ProjectNexo [id=" + id + ", name=" + name + ", slug=" + slug + "]";
	}

}
