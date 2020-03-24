package io.fip.client.model;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

@JsonAdapter(CatalogoExclusion.Adapter.class)
public enum CatalogoExclusion {

	E1("E1"),

	E2("E2");

	private String value;

	CatalogoExclusion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static CatalogoExclusion fromValue(String text) {
		for (CatalogoExclusion b : CatalogoExclusion.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

	public static class Adapter extends TypeAdapter<CatalogoExclusion> {
		@Override
		public void write(final JsonWriter jsonWriter, final CatalogoExclusion enumeration) throws IOException {
			jsonWriter.value(enumeration.getValue());
		}

		@Override
		public CatalogoExclusion read(final JsonReader jsonReader) throws IOException {
			String value = jsonReader.nextString();
			return CatalogoExclusion.fromValue(String.valueOf(value));
		}
	}
}
