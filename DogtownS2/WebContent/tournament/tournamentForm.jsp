<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


		<title>Dogtown Invitational - Touranment</title>
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_page.css"  />
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_table_jui.css"  /> 
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/themes/smoothness/jquery-ui-1.8.4.custom.css"  />    

<script type="text/javascript" src="/DogtownS2/javascript/jquery.js"></script> 
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

  <script>  $(function() {    $( "#dayOneDateText" ).datepicker();  });  </script>
  <script>  $(function() {    $( "#dayTwoDateText" ).datepicker();  });  </script>

<h3>Tournament Form</h3>
<br/><br/>
<s:form action="" theme="simple">
<s:hidden name="tournament.id" value="%{tournament.id}"/>
<s:hidden name="edit" value="%{edit}"/> 

<fieldset>
<legend>Tournament</legend>
<br/>
	<table>
		<tr>
			<td class="align-left">
				<s:text name="Tournament Name:"/>
			</td>
			<td class="align-left">
				<s:textfield id="tournamentNameText" name="tournament.name" value="%{tournament.name}" size="40"></s:textfield>
			</td>
		</tr>
	</table>
</fieldset>

<br/>

<fieldset>
<legend>Day 1</legend>
<br/>	
	<table>
		<tr>
			<td class="align-left">
				<s:text name="Date:"/>
			</td>
			<td class="align-left">
			     <s:textfield id="dayOneDateText" name="tournament.firstDay.date" 
                       value="%{getText('format.date',{tournament.firstDay.date})}" />
			</td>
			<td class="align-left">
				<s:text name="Course:"/>
			</td>
			<td class="align-left">
				<s:textfield id="dayOneCourseText" name="tournament.firstDay.course"></s:textfield>
			</td>
		</tr>
	</table>
</fieldset>

<br/><br/>

<fieldset>
<legend>Day 2</legend>
<br/>	
	<table>
		<tr>
			<td class="align-left">
				<s:text name="Date:"/>
			</td>
			<td class="align-left">
			    <s:textfield id="dayTwoDateText" name="tournament.secondDay.date"
                       value="%{getText('format.date',{tournament.secondDay.date})}" />
			</td>
			<td class="align-left">
				<s:text name="Course:"/>
			</td>
			<td class="align-left">
				<s:textfield id="dayTwoCourseText" name="tournament.secondDay.course"></s:textfield>
			</td>
		</tr>
	</table>
</fieldset>

<br/><br/>

<table>
	<tr>
		<td>
			<s:submit id="save" type="submit" action="saveTournament" value="Save"/>
		</td>
		<td>
			<s:submit id="addPlayer" type="submit" action="addTournamentPlayer" value="Add Player" />
		</td>
		<td>
			<s:submit id="cancel" type="submit" action="cancel" value="Return"/>
		</td>
	</tr>
</table>
</s:form>


