<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	    				
		    		<s:form action="scoreboardFlightListing" theme="simple">
					
					<h1>Scoreboard</h1>
					
					<table>
						<tr>
							<td class="align-left">
								<s:text name="Tournament:"/>
							</td>
							<td class="align-left">
								<s:property value="#{TournamentBean.tournament.name}"/>
							</td>
						</tr>
					</table>
					

						<s:text name="Flight"/>

						<s:a href="#{ScoreboardBean.displayScoreboard}">Display Scoreboard</s:a>
				        <s:property value="#{scoreboard.flight.name}"/>

						<s:text name="Players"/>									

				        <s:property value="#{scoreboard.totalPlayers}"/>
						
						
						<h1>Day 1 Skins</h1>

						<s:text name="Skin Game"/>

						<s:a href="#{ScoreboardBean.displayDayOneSkinGame}">dfg</s:a>
				        <s:text name="#{skinGame.skin.name}"/>

						<s:text name="Players"/>									


				        <s:property value="#{skinGame.totalPlayers}"/>

						<s:text name="Skins Out"/>									

				        <s:property value="#{skinGame.skinsOut}"/>

						<h1>Day 2 Skins</h1>
					

						<s:text name="Skin Game"/>

						<s:a action="#{ScoreboardBean.displayDayTwoSkinGame}">sdf</s:a>
				        <s:property value="#{skinGame.skin.name}"/>

						<s:text name="Players"/>									

				        <s:property value="#{skinGame.totalPlayers}"/>
						<s:text name="Skins Out"/>									

				        <s:property value="#{skinGame.skinsOut}"/>					
					</s:form>



