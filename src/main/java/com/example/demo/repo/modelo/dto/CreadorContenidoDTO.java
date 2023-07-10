package com.example.demo.repo.modelo.dto;

public class CreadorContenidoDTO {

	private String usuarioDTO;
	private String emailDTO;

	public CreadorContenidoDTO() {
		super();
	}

	public CreadorContenidoDTO(String usuarioDTO, String emailDTO) {
		super();
		this.usuarioDTO = usuarioDTO;
		this.emailDTO = emailDTO;
	}

	// Get y set

	public String getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(String usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public String getEmailDTO() {
		return emailDTO;
	}

	public void setEmailDTO(String emailDTO) {
		this.emailDTO = emailDTO;
	}

	@Override
	public String toString() {
		return "CreadorContenidoDTO [usuarioDTO=" + usuarioDTO + ", emailDTO=" + emailDTO + "]";
	}

}
