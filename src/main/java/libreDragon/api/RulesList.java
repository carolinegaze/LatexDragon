package libreDragon.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ruleslist")
public class RulesList {

	@Path("{gameid}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String answer (@PathParam("gameid") String gameId) {
		Reponse reponse = new Reponse();
		String complementaryInfo, status;
		if (!Data.isIn(gameId)) {
			status = "FAILURE";
			complementaryInfo = "Session introuvable !";
			return reponse.info(gameId, status, complementaryInfo);
		}
		return reponse.rulesList(gameId);
	}
}
