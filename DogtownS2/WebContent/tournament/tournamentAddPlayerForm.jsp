<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

	    			
 <s:form id="addPlayerForm" action="tournamentPlayer.action" theme="simple">

<h1>Add Player Form</h1>

<table>
	<tr>
		<td class="align-left">
			<s:text name="Tournament:"/>
		</td>
		<td class="align-left">
			<s:property value="tournament.name"/>
		</td>
	</tr>
</table>

<div id="content-title">
<h2>Add Tournament Player</h2>
<br/>
	<table>
		<tr>
			<td class="align-left">
				<s:text name="Player"/>
			</td>
			
			<td class="align-left">
			   <s:if test="%{edit!=true}">
				<s:select list="%{playerItems}" name="player.id" listValue="fullName" listKey="id"/>
			   </s:if>
			   <s:if test="%{edit==true}">
			    <s:property value="%{player.fullName}"/>
				<s:hidden value="%{player.id}" name="player.id"/>
				<s:hidden value="%{tournamentPlayerScorecard.dayOneScorecard.id}" name="tournamentPlayerScorecard.dayOneScorecard.id"/>
				<s:hidden value="%{tournamentPlayerScorecard.dayTwoScorecard.id}" name="tournamentPlayerScorecard.dayTwoScorecard.id"/>
				<s:hidden value="true" name="edit"/>
			   </s:if>
			</td>
		</tr>
		<tr>
			<td valign="top" class="align-left">
				<s:text name="Handicap:"/>
			</td>
			<td valign="top" class="align-left">
				<s:textfield name="handicap" size="2" maxlength="2" javascriptTooltip="Enter Handicap"></s:textfield></td>
			<td valign="top" class="align-left">
				<s:text name="Flight:"/>
			</td>
			<td valign="top" class="align-left">
			    <s:select list="%{flightItems}" listValue="name" listKey="id" name="flightArray" value="%{flightArray}" multiple="true"></s:select>
			</td>
		</tr>
	</table>
</div>

<br/><br/>

<s:if test="%{edit!=true}">
<h2>Tournament Players</h2>

	<table>
	<tr>
	   <th>Name</th>
	   <th>Handicap</th>
	   <th>Flights</th>
	</tr> 
	<s:iterator value="#request.tournament.tournamentPlayerScrorecards"> 
         <tr>
	        <td>
	         <s:url id="url" action="editPlayerScorecard">
	             <s:param value="true" name="edit"/>
	             <s:param value="player.id" name="player.id"/>
	             <s:param value="dayOneScorecard.id" name="tournamentPlayerScorecard.dayOneScorecard.id"/>
	             <s:param value="dayTwoScorecard.id" name="tournamentPlayerScorecard.dayTwoScorecard.id"/>
	         </s:url>
                   <s:a href="%{url}"><s:property value="player.fullName"/></s:a>
	        </td>
	        <td><s:property value="handicap"/></td>
	        <td><s:property value="flight"/></td>
        </tr>
		</s:iterator>
</table>
</s:if>
<br/><br/>


<table>
	<tr>
		<td>
			<s:submit id="save" type="submit" action="saveTournamentPlayer" value="Save"/>
		</td>
		<td>
			<s:submit id="cancel" type="submit" action="cancel" value="Return" />
		</td>
	</tr>
</table>
</s:form>


