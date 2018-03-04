package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Image
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-16T20:34:37.063Z")
@Entity
public class Image   {
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id = null;

	@Column(name="file")
	private byte[] file = null;

	@JsonProperty("date")
	@Column(name="date")
	private String date = null;


	@JsonProperty("titre")
	@Column(name="titre")
	private String titre = null;

	@JsonProperty("idUtilisateur")
	@Column(name="id_utilisateur")
	private Long idUtilisateur = null;

	public Image file(byte[] file) {
		this.file = file;
		return this;
	}

	/**
	 * Get chemin
	 * @return chemin
	 **/
	@ApiModelProperty(value = "")


	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Image date(String date) {
		this.date = date;
		return this;
	}

	/**
	 * Get date
	 * @return date
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Image id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(value = "")


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image titre(String titre) {
		this.titre = titre;
		return this;
	}

	/**
	 * Get titre
	 * @return titre
	 **/
	@ApiModelProperty(value = "")


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Image idutilisateur(Long id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
		return this;
	}

	/**
	 * Get idutilisateur
	 * @return idutilisateur
	 **/
	@ApiModelProperty(value = "")


	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Image image = (Image) o;
		return Objects.equals(this.file, image.file) &&
				Objects.equals(this.date, image.date) &&
				Objects.equals(this.id, image.id) &&
				Objects.equals(this.titre, image.titre) &&
				Objects.equals(this.idUtilisateur, image.idUtilisateur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, date, id, titre, idUtilisateur);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Image {\n");

		sb.append("    file: ").append(toIndentedString(file)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    titre: ").append(toIndentedString(titre)).append("\n");
		sb.append("    idutilisateur: ").append(toIndentedString(idUtilisateur)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

