package io.swagger.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="id")
	private Long id = null;

	@JsonProperty("chemin")
	@Column(name="chemin")
	private String chemin = null;

	@JsonProperty("date")
	@Column(name="date")
	private String date = null;


	@JsonProperty("nomimage")
	@Column(name="nom_image")
	private String nomimage = null;

	@JsonProperty("idutilisateur")
	@Column(name="id_utilisateur")
	private Long id_utilisateur = null;

	public Image chemin(String chemin) {
		this.chemin = chemin;
		return this;
	}

	/**
	 * Get chemin
	 * @return chemin
	 **/
	@ApiModelProperty(value = "")


	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
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

	public Image nomimage(String nomimage) {
		this.nomimage = nomimage;
		return this;
	}

	/**
	 * Get nomimage
	 * @return nomimage
	 **/
	@ApiModelProperty(value = "")


	public String getNomimage() {
		return nomimage;
	}

	public void setNomimage(String nomimage) {
		this.nomimage = nomimage;
	}

	public Image idutilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
		return this;
	}

	/**
	 * Get idutilisateur
	 * @return idutilisateur
	 **/
	@ApiModelProperty(value = "")


	public Long getIdUtilisateur() {
		return id_utilisateur;
	}

	public void setIdUtilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
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
		return Objects.equals(this.chemin, image.chemin) &&
				Objects.equals(this.date, image.date) &&
				Objects.equals(this.id, image.id) &&
				Objects.equals(this.nomimage, image.nomimage) &&
				Objects.equals(this.id_utilisateur, image.id_utilisateur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(chemin, date, id, nomimage, id_utilisateur);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Image {\n");

		sb.append("    chemin: ").append(toIndentedString(chemin)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nomimage: ").append(toIndentedString(nomimage)).append("\n");
		sb.append("    nompersonne: ").append(toIndentedString(id_utilisateur)).append("\n");
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

