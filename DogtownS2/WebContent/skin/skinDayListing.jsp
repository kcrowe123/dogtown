<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_page.css"  />
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_table_jui.css"  /> 
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/themes/smoothness/jquery-ui-1.8.4.custom.css"  />    

    <script type="text/javascript" src="/DogtownS2/javascript/jquery.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.min.js"></script>
    
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				oTable = $('#cc').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers"		
				});
			} );
		</script>   

	    				
<s:form action="skinDayListing" theme="simple">

<h1>Pick a Skins Player</h1>

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
			<s:property value="{day}"/>
		</td>
	</tr>
</table>


<s:hidden name="tournament.id" value="%{#session.tournament.id}"/>

<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    

		        <th>Name</th>             
				<th>Flights</th>             
				<th>Skins Games</th>                    	     
						
		</tr>     
	</thead>  
	
		<tbody>  
	
		<s:iterator value="#request.day.scorecards">
			<tr>
			      <td>
			         <s:url id="url" action="editSkinsGame">
			             <s:param value="id" name="scorecard.id"/>
			             <s:param value="day.id" name="day.id"/>
			         </s:url>
                     <s:a href="%{url}"><s:property value="player.fullName"/></s:a>
                  </TD>
	             <TD>
                     <s:property value="scorecardFlights"/>
	             </TD>
	             <TD>
	             	 <s:property value="scorecardSkinsGames"/>
	             </TD>
			</tr>
		</s:iterator> 
		


	</tbody> 
</table>	   
	<tbody>  
	

			
		



	
</s:form>


