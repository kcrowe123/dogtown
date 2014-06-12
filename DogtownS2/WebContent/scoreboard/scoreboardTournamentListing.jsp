<%@ page contentType="text/html; charset=UTF-8"%>
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

	    				
<s:form action="scoreboardTournamentListing" theme="simple">

<h1>Scoreboard Tournament Listing</h1>


<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    
	        <th>Name</th>             
			<th>Day 1</th>             
			<th>Day 2</th> 
			<th># Players</th>                      	     	
		</tr>     
	</thead>     
	<tbody>  
		<s:iterator value="#request.tournaments">
		<tr>
		      <td>
			      <s:url id="url" action="loadTournamentPlayers">
			              <s:param value="id" name="tournamentId"/>
			          </s:url>
                  <s:a href="%{url}"><s:property value="name"/></s:a>
                 </TD>
             <TD>
                <s:property value="getText('format.date',{firstDay.date})" />
                <s:text name="    "/>
                <s:property value="%{firstDay.course}"/>
             </TD>
             <TD>
                <s:property value="getText('format.date',{secondDay.date})" />
                <s:text name="    "/>
                <s:property value="%{secondDay.course}"/>
             </TD>
		     <TD><s:property value="%{totalNumberOfPlayers}" /></TD>
		</tr>
		</s:iterator>
	</tbody> 
</table>
		
	
</s:form>


