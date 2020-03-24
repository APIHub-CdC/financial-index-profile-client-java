package io.fip.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class Respuesta {
	@SerializedName("folioScore")
	private String folioScore = null;
	@SerializedName("folioConsulta")
	private String folioConsulta = null;
	@SerializedName("score")
	private CatalogoScores score = null;
	@SerializedName("exclusion")
	private CatalogoExclusion exclusion = null;

	public Respuesta folioScore(String folioScore) {
		this.folioScore = folioScore;
		return this;
	}

	@ApiModelProperty(example = "618658674", value = "Número de consulta asignado por Círculo de Crédito para identificar una Consulta efectuada(obtenido en la consulta del servicio de madurez.")
	public String getFolioScore() {
		return folioScore;
	}

	public void setFolioScore(String folioScore) {
		this.folioScore = folioScore;
	}

	public Respuesta folioConsulta(String folioConsulta) {
		this.folioConsulta = folioConsulta;
		return this;
	}

	@ApiModelProperty(example = "618658673", value = "Número de consulta asignado por Círculo de Crédito para identificar una Consulta efectuada(obtenido del reporte de crédito).")
	public String getFolioConsulta() {
		return folioConsulta;
	}

	public void setFolioConsulta(String folioConsulta) {
		this.folioConsulta = folioConsulta;
	}

	public Respuesta score(CatalogoScores score) {
		this.score = score;
		return this;
	}

	@ApiModelProperty(value = "")
	public CatalogoScores getScore() {
		return score;
	}

	public void setScore(CatalogoScores score) {
		this.score = score;
	}

	public Respuesta exclusion(CatalogoExclusion exclusion) {
		this.exclusion = exclusion;
		return this;
	}

	@ApiModelProperty(value = "")
	public CatalogoExclusion getExclusion() {
		return exclusion;
	}

	public void setExclusion(CatalogoExclusion exclusion) {
		this.exclusion = exclusion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Respuesta respuesta = (Respuesta) o;
		return Objects.equals(this.folioScore, respuesta.folioScore)
				&& Objects.equals(this.folioConsulta, respuesta.folioConsulta)
				&& Objects.equals(this.score, respuesta.score) && Objects.equals(this.exclusion, respuesta.exclusion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folioScore, folioConsulta, score, exclusion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Respuesta {\n");

		sb.append("    folioScore: ").append(toIndentedString(folioScore)).append("\n");
		sb.append("    folioConsulta: ").append(toIndentedString(folioConsulta)).append("\n");
		sb.append("    score: ").append(toIndentedString(score)).append("\n");
		sb.append("    exclusion: ").append(toIndentedString(exclusion)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
