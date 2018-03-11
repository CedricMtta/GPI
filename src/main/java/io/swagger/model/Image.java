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
 * Class used to represent an image
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

	/**
	 * Update the bytes table and return the image 
	 * 
	 * @param file bytes table which represents the image
	 * @return the image
	 */
	public Image file(byte[] file) {
		this.file = file.clone();
		return this;
	}

	/**
	 * Return the bytes table which represents the image
	 * @return the bytes table which represents the image
	 **/
	@ApiModelProperty(value = "")


	public byte[] getFile() {
		if(this.file == null)
			return null;
		return this.file.clone();
	}

	/**
	 * Set the bytes table which represents the image
	 * @param file the bytes table which represents the image
	 */
	public void setFile(byte[] file) {
		this.file = file.clone();
	}

	/**
	 * Set the date of the image and return the image
	 * @param date the date to associate to the image
	 * @return the image
	 */
	public Image date(String date) {
		this.date = date;
		return this;
	}

	/**
	 * Get the date associated to the image
	 * @return date the date associated to the image
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public String getDate() {
		return date;
	}

	/**
	 * Set the date of the image
	 * @param date the date to associate to the image
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Set the id of the image and return the image
	 * @param id the id to associate to the image
	 * @return the image
	 */
	public Image id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Return the id of the image
	 * @return the id associated to the image
	 **/
	@ApiModelProperty(value = "")


	public Long getId() {
		return id;
	}

	/**
	 * Set the id of the image
	 * @param id the id to associate to the image
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Set the title of the image and return the image
	 * @param titre the title to associate to the image
	 * @return the image
	 */
	public Image titre(String titre) {
		this.titre = titre;
		return this;
	}

	/**
	 * Return the title of the image
	 * @return titre the title associated to the image
	 **/
	@ApiModelProperty(value = "")


	public String getTitre() {
		return titre;
	}

	/**
	 * Set the title of the image
	 * @param titre the title to associate to the image
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Set the id of the the user who post the image and return the image
	 * @param id_utilisateur the id of the user who post the image
	 * @return the image
	 */
	public Image idutilisateur(Long id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
		return this;
	}

	/**
	 * Return the id of the user who post the image
	 * @return idutilisateur the id of the user who post the image
	 **/
	@ApiModelProperty(value = "")


	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Set the id of the user who post the image
	 * @param id_utilisateur the id of the user who post the image
	 */
	public void setIdUtilisateur(Long id_utilisateur) {
		this.idUtilisateur = id_utilisateur;
	}

	/**
	 * Compare the image with the object in parameter
	 * Return true if the object is an image and all fields are equals
	 * @param o the object to compare
	 */
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Image image = (Image) o;
		return this.file == image.file &&
				Objects.equals(this.date, image.date) &&
				Objects.equals(this.id, image.id) &&
				Objects.equals(this.titre, image.titre) &&
				Objects.equals(this.idUtilisateur, image.idUtilisateur);
	}

	/**
	 * Return the hash code
	 * {@inheritDoc}
	 * @return the hash code of the image
	 */
	@Override
	public int hashCode() {
		return Objects.hash(file, date, id, titre, idUtilisateur);
	}

	/**
	 * Return a string which represents the image
	 * @return a string which represents the image
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Image {\n");

		sb.append("    file: ").append(toIndentedString(file)).append('\n');
		sb.append("    date: ").append(toIndentedString(date)).append('\n');
		sb.append("    id: ").append(toIndentedString(id)).append('\n');
		sb.append("    titre: ").append(toIndentedString(titre)).append('\n');
		sb.append("    idutilisateur: ").append(toIndentedString(idUtilisateur)).append('\n');
		sb.append('}');
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

