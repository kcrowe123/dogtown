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
	    		
	    				
	
	<h1><tiles:insertAttribute name="title" ignore="true" /></h1>
	
	<table>
		<tr>
			<td class="align-left" >
				<s:text name="Tournament:"/>
			</td>
			<td class="align-left">
				<s:text name="#session.tournamentKey.name"/>
			</td>
		</tr>
	</table>
		
<s:form id="tournamentListing"  theme="simple">

<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    

		        <th><s:text name="Name"/></th>             
				<th><s:text name="Handicap"/></th>             
				<th><s:text name="Day 1"/></th> 
				<th><s:text name="Day 1 Total"/></th>
				<th><s:text name="Day 2"/></th> 
				<th><s:text name="Day 2 Total"/></th>                      	     
				
				
		</tr>     
	</thead>     
	<tbody>  
		<s:iterator value="#request.tournamentPlayerScorecards">
			<tr>
			      <td><s:url id="url" action="editScorecard">
			             <s:param name="playerId" value="player.id"/>
                         <s:param name="dayOneScorecardId" value="dayOneScorecard.id"/>
                         <s:param name="dayTwoScorecardId" value="dayTwoScorecard.id"/>
			          </s:url>
                      <s:a href="%{url}"><s:property value="player.fullName"/></s:a></TD>
	             <TD><s:property value="handicap" /></TD>
			     <TD><s:property value="dayOneScorecard.score" /></TD>
			     <TD><s:property value="dayOneScorecard.handicapScore" /></TD>
			     <TD><s:property value="dayTwoScorecard.score" /></TD>
			     <TD><s:property value="dayTwoScorecard.handicapScore" /></TD>
			</tr>
		</s:iterator>
	</tbody> 
</table>
	
	
	</s:form>	



