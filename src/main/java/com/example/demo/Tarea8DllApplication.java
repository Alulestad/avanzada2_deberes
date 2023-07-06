package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Video;
import com.example.demo.service.IVideoService;

@SpringBootApplication
public class Tarea8DllApplication implements CommandLineRunner {

	@Autowired
	private IVideoService iVideoRService;

	public static void main(String[] args) {
		SpringApplication.run(Tarea8DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Video> videos1 = this.iVideoRService.reporteEntreFechasResolucion(LocalDateTime.of(2006, 01, 01, 0, 0),
				LocalDateTime.of(2009, 01, 01, 0, 0), 720);
		videos1.forEach(System.out::println);

		List<Video> videos2 = this.iVideoRService.reporteEntreFechasResolucion(LocalDateTime.of(2004, 01, 01, 0, 0),
				LocalDateTime.of(2009, 01, 01, 0, 0), 720);
		videos2.forEach(System.out::println);

		int filasActualizadas = this.iVideoRService.actualizarComentariosPorDuracion(Double.valueOf(9),
				Boolean.valueOf(true));
		System.out.println("Filas actualizadas: " + filasActualizadas);

		int filasEliminadas = this.iVideoRService.eliminarParaUsuarioYFecha("warrr",
				LocalDateTime.of(2050, 02, 05, 0, 0));
		System.out.println("Filas eliminadas: " + filasEliminadas);

	}

}
