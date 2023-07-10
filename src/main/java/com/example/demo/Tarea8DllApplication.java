package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.ICreadorContenidoRepo;
import com.example.demo.repo.IVideoRepo;
import com.example.demo.repo.modelo.Video;
import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;
import com.example.demo.service.ICreadorContenidoService;
import com.example.demo.service.IVideoService;

@SpringBootApplication
public class Tarea8DllApplication implements CommandLineRunner {

	@Autowired
	private IVideoService iVideoRService;
	
	@Autowired
	private ICreadorContenidoService iCreadorContenidoService;

	public static void main(String[] args) {
		SpringApplication.run(Tarea8DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("#######DTO#######");
		CreadorContenidoDTO creadorContenidoDTO1= iCreadorContenidoService.buscarCreadorContenidoDTOPorVideoID(1);
		System.out.println(creadorContenidoDTO1);
		
		System.out.println("#######Fetch Lazy#######");
		List<Video> videos= iVideoRService.reportePorFechaSubida(LocalDateTime.of(2023, 03, 02, 0, 0));
		videos.forEach((v)->{
			System.out.println("#Video n segun la fecha#");
			System.out.println(v);
			System.out.println("Creador de contenido propietario");
			System.out.println(v.getCreadorContenido());
			
		});
		
		
	}

}
