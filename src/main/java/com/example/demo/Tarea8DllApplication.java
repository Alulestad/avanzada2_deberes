package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.CreadorContenido;
import com.example.demo.repo.modelo.Video;
import com.example.demo.service.ICreadorContenidoService;
import com.example.demo.service.IVideoService;

@SpringBootApplication
public class Tarea8DllApplication implements CommandLineRunner {

	@Autowired
	private IVideoService iVideoService;

	@Autowired
	private ICreadorContenidoService iCreadorContenidoService;

	public static void main(String[] args) {
		SpringApplication.run(Tarea8DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inner
		System.out.println("#########################INNER JOINS#########################");
		System.out.println("********INNER JOIN CC********");
		List<CreadorContenido> cc1 = this.iCreadorContenidoService.buscarTodosInnerJoin();
		cc1.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			if (cc != null) {
				System.out.println("Videos:");
				List<Video> v1 = cc.getVideos();
				v1.forEach(System.out::println);

			} else {
				System.out.println("No existe aun creador de contenido");
			}

		});

		System.out.println("********INNER JOIN VIDEO********");
		List<Video> v1 = this.iVideoService.buscarTodosInnerJoin();
		v1.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);
			if (v != null) {
				System.out.println("Creador:");
				System.out.println(v.getCreadorContenido());
			} else {
				System.out.println("No existe aun video");
			}

		});

		// RIGHT
		System.out.println("#########################OUTER RIGHT JOINS#########################");
		System.out.println("********OUTER RIGHT JOIN CC********");
		List<CreadorContenido> cc2 = this.iCreadorContenidoService.buscarTodosOuterRightJoin();
		cc2.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			if (cc != null) {
				System.out.println("Videos:");
				List<Video> v = cc.getVideos();
				v.forEach(System.out::println);
			} else {
				System.out.println("No existe aun creador de contenido");
			}

		});

		System.out.println("********OUTER RIGHT JOIN VIDEO********");
		List<Video> v2 = this.iVideoService.buscarTodosOuterRightJoin();
		v2.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);
			if (v != null) {
				System.out.println("Creador:");
				System.out.println(v.getCreadorContenido());
			} else {
				System.out.println("No existe aun video");
			}

		});

		// LEFT
		System.out.println("#########################OUTER LEFT JOINS#########################");
		System.out.println("********OUTER LEFT JOIN CC********");
		List<CreadorContenido> cc3 = this.iCreadorContenidoService.buscarTodosOuterLeftJoin();
		cc3.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			if (cc != null) {
				System.out.println("Videos:");
				List<Video> v = cc.getVideos();
				v.forEach(System.out::println);
			} else {
				System.out.println("No existe aun creador de contenido");
			}

		});

		System.out.println("********OUTER LEFT JOIN VIDEO********");
		List<Video> v3 = this.iVideoService.buscarTodosOuterLeftJoin();
		v3.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);
			if (v != null) {
				System.out.println("Creador:");
				System.out.println(v.getCreadorContenido());
			} else {
				System.out.println("No existe aun video");
			}

		});

		// FULL
		System.out.println("#########################OUTER FULL JOINS#########################");
		System.out.println("********OUTER FULL JOIN CC********");
		List<CreadorContenido> cc4 = this.iCreadorContenidoService.buscarTodosOuterFullJoin();
		cc4.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			if (cc != null) {
				System.out.println("Videos:");
				List<Video> v = cc.getVideos();
				v.forEach(System.out::println);
			} else {
				System.out.println("No existe aun creador de contenido");
			}

		});

		System.out.println("********OUTER FULL JOIN VIDEO********");
		List<Video> v4 = this.iVideoService.buscarTodosOuterFullJoin();
		v4.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);
			if (v != null) {
				System.out.println("Creadores:");
				System.out.println(v.getCreadorContenido());
			} else {
				System.out.println("No existe aun video");
			}

		});

		// WHERE
		System.out.println("#########################WHERE JOINS#########################");
		System.out.println("********WHERE JOIN CC********");
		List<CreadorContenido> cc5 = this.iCreadorContenidoService.buscarTodosWhereJoin();
		cc5.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			if (cc != null) {
				System.out.println("Videos:");
				List<Video> v = cc.getVideos();
				v.forEach(System.out::println);
			} else {
				System.out.println("No existe aun creador de contenido");
			}

		});

		System.out.println("********WHERE JOIN VIDEO********");
		List<Video> v5 = this.iVideoService.buscarTodosWhereJoin();
		v5.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);
			if (v != null) {
				System.out.println("Creador:");
				System.out.println(v.getCreadorContenido());
			} else {
				System.out.println("No existe aun video");
			}

		});

		// Fetch
		System.out.println("#########################JOIN FETCH#########################");
		System.out.println("********JOIN FETCH CC********");
		List<CreadorContenido> cc6 = this.iCreadorContenidoService.buscarTodosJoinFetch();
		cc6.forEach(cc -> {
			System.out.println("#CREADOR#");
			System.out.println(cc);
			System.out.println("Videos:");
			List<Video> v = cc.getVideos();
			v.forEach(System.out::println);

		});

		System.out.println("********JOIN FETCH VIDEO********");
		List<Video> v6 = this.iVideoService.buscarTodosJoinFetch();
		v6.forEach(v -> {
			System.out.println("#VIDEO#");
			System.out.println(v);

			System.out.println("Creador:");
			System.out.println(v.getCreadorContenido());


		});

	}

}
