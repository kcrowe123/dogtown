<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


	<head>
		<title>Dogtown Invitational - <h:text name="#{TournamentBean.tournament.name}"/> <h:text name=" #{ScoreboardBean.skinGame.skin.name}"/> Skin Game Scoreboard</title>
		<link rel="stylesheet" type="text/css" href="/dogtown/css/styles.css" />
	
	</head><br>

	    				
		    		<s:form id="scoreboard" theme="simple">
					 
					<h1>Skin Game Scoreboard</h1>
					
					<table>
						<tr>
							<td class="align-left" >
								
							</td>
							<td class="align-left">
								
							</td>
							<td class="align-left">
								
							</td>
							<td class="align-left">
								
							</td>
						</tr>
						<tr>
							<td class="align-left" >
								
							</td>
							<td class="align-left">
								
							</td>
							<td class="align-left">
								
							</td>
							<td class="align-left">
								
							</td>
						</tr>
					</table>
					

						
							
				
		        
				
		        
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        
			
		
		
			
				
			
			
		        

					
					<table>
						<tr>
							<td>le
								<s:submit id="cancel" type="submit" action="#{ScoreboardBean.cancel}" value="Return" />
							</td>
						</tr>
					</table>
					
					</s:form>




