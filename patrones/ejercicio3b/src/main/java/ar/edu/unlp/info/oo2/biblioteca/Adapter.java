package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.*;


public class Adapter extends VoorheesExporter{
	
	@SuppressWarnings("unchecked")
	private JSONObject exportarSocioToJson(Socio socio) {
		JSONObject obj = new JSONObject();
		obj.put("nombre", socio.getNombre());
		obj.put("email", socio.getEmail());
		obj.put("legajo", socio.getLegajo());
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public String exportar(List<Socio> socios) {
		
		JSONArray jsonArray = new JSONArray();
		
		for (Socio socio : socios) {
	        jsonArray.add(exportarSocioToJson(socio));
	    }
	    return jsonArray.toJSONString();
		
	}
}
