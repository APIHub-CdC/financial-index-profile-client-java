package io.fip.client.model;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

@JsonAdapter(CatalogoScores.Adapter.class)
public enum CatalogoScores {

	N1("N1"),

	N2("N2"),

	N3("N3"),

	N4("N4"),

	N5("N5");

	private String value;

	CatalogoScores(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static CatalogoScores fromValue(String text) {
		for (CatalogoScores b : CatalogoScores.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	public static class Adapter extends TypeAdapter<CatalogoScores> {
		@Override
		public void write(final JsonWriter jsonWriter, final CatalogoScores enumeration) throws IOException {
			jsonWriter.value(enumeration.getValue());
		}

		@Override
		public CatalogoScores read(final JsonReader jsonReader) throws IOException {
			String value = jsonReader.nextString();
			return CatalogoScores.fromValue(String.valueOf(value));
		}
	}
}
