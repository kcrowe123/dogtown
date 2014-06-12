<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	    		

	    				
<s:form id="skinPlayerForm" theme="simple">
<s:hidden name="tournament.id" value="%{#session.tournament.id}"/>
<h1>Add Player Skin Games</h1>

<table>
	<tr>
		<td class="align-left">
			<s:text name="Tournament:"/>
		</td>
		<td class="align-left">
			<s:property value="%{tournament.name}"/>
		</td>
		<td class="align-left">
			<s:text name="Day:"/>
		</td>
		<td class="align-left">
			<s:property value="%{day.name}"/>
		</td>
	</tr>
	<tr>
		<td class="align-left">
			<s:text name="Player:"/>
		</td>
		<td class="align-left">
		    <s:property value="%{scorecard.player.fullName}"/>
		</td>	
		<td class="align-left">
			<s:text name="Flight(s):"/>
		</td>
		<td class="align-left">
		    <s:property value="%{scorecard.scorecardFlights}"/>
		</td>
	</tr>
</table>


<div id="content-title">
<h2>Add Skins Game</h2>
<br/>
	<table>
		<tr>
			<td valign="top" class="align-left">
				<s:text name="Skin Games:"/>
			</td>
			<td valign="top" class="align-left">
				<s:select name="skinArray" value="%{skinArray}"  list="%{skinGameItems}" listKey="id" listValue="name" multiple="true" />
			</td>
		</tr>
	</table>
</div>

<table>
	<tr>
		<td>
			<s:submit id="save" type="submit" action="saveSkinGames" value="Save"/>
		</td>
		<td>
			<s:submit id="cancel" type="submit" action="cancel" value="Return"/>
		</td>
	</tr>
</table>

	
</s:form>


