<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

		<title>Dogtown Invitational - <s:text name="#{TournamentBean.tournament.name}"/> <s:text name=" #{ScoreboardBean.scoreboard.flight.name}"/> Flight Scoreboard Listing</title>
		<link rel="stylesheet" type="text/css" href="/dogtown/css/styles.css" />


	    				
   		<s:form id="scoreboard" theme="simple">
		
		<h1>Scoreboard</h1>
		
		<table>
			<tr>
				<td class="align-left" >
					<s:text name="Tournament:"/>
				</td>
				<td class="align-left">
					<s:property value="#{TournamentBean.tournament.name}"/>
				</td>
				<td class="align-left">
					<s:text name="Flight:"/>
				</td>
				<td class="align-left">
					<s:property value="#{ScoreboardBean.scoreboard.flight.name}"/>
				</td>
			</tr>
		</table>
		
		
			
				
					<s:text name="Player"/>
				
				
			        <s:property value="#{scorecard.player.fullName}"/>
				
			
			
				
					<s:text name="Day 1"/>
				
				
			        <s:property value="#{scorecard.dayOneScorecard.score}"/> / <s:text name="#{scorecard.dayOneScorecard.handicapScore}"/>
				
			
			
				
					<s:text name="Day 2"/>
				
				
			        <s:property value="#{scorecard.dayTwoScorecard.score}"/>  / <s:text name="#{scorecard.dayTwoScorecard.handicapScore}"/>
				
			
			
				
					<s:text name="Total"/>
				
				
			        <s:property value="#{scorecard.twoDayTotal}"/>
				
			
			
				
					<s:text name="Handicap"/>
				
				
			        <s:property value="#{scorecard.handicap}"/> 
				
			
			
				
					<s:text name="Net"/>
				
				
			        <s:property value="#{scorecard.twoDayHandicapTotal}"/>
				
			

		
		<table>
			<tr>
				<td>
					<s:submit id="cancel" type="submit" action="#{ScoreboardBean.cancel}" value="Return" />
				</td>
			</tr>
		</table>
		
		</s:form>




