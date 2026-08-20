<%@page import="com.dimata.balismartisland.form.FrmAreaList"%>
<%@page import="com.dimata.balismartisland.form.FrmAreaUsage"%>
<%@page import="com.dimata.balismartisland.form.FrmAreaType"%>
<%@page import="com.dimata.balismartisland.form.FrmChanel"%>
<%@page import="com.dimata.balismartisland.entity.AreaList"%>
<%@page import="com.dimata.balismartisland.entity.PstAreaList"%>
<%@page import="com.dimata.balismartisland.entity.AreaUsage"%>
<%@page import="com.dimata.balismartisland.entity.PstAreaUsage"%>
<%@page import="com.dimata.balismartisland.entity.AreaType"%>
<%@page import="com.dimata.balismartisland.entity.PstAreaType"%>
<%@page import="com.dimata.balismartisland.entity.Chanel"%>
<%@page import="com.dimata.balismartisland.entity.ChanelType"%>
<%@page import="java.util.Vector"%>
<%@page import="com.dimata.balismartisland.entity.PstChanel"%>
<%@page import="com.dimata.balismartisland.entity.PstChanelType"%>

<%
    String topLeft = "";
    String topRight = "";
    String bottomLeft = "";
    String bottomRight = "";
    String topLeftHeader = "";
    String topRightHeader = "";
    String bottomLeftHeader = "";
    String bottomRightHeader = "";
    Vector listChanelType = PstChanelType.listAll();
    if(listChanelType.size() > 0){
	for(int i = 0; i < listChanelType.size(); i++){
	    ChanelType chanelType = (ChanelType) listChanelType.get(i);
	    String header = chanelType.getName();
	    String content = "";
	    
	    Vector listChanel = PstChanel.list(0, 0, ""+PstChanel.fieldNames[PstChanel.FLD_CHANEL_TYPE_ID]+"='"+chanelType.getOID()+"'", "");
	    if(listChanel.size() > 0){
		for(int iChanel = 0; iChanel < listChanel.size(); iChanel++){
		    Chanel chanel = (Chanel) listChanel.get(iChanel);
		    String parameter = "?"+FrmChanel.fieldNames[FrmChanel.FRM_FIELD_CHANEL_ID]+"="+chanel.getOID();
		    content+="<li class='dropdown'><a href='monitor.jsp"+parameter+"' class='dropdown-toggle' data-toggle='dropdown'>"+chanel.getChanelName()+"  <span class='caret'></span></a>";
		    
		    Vector listGroup = PstAreaType.list(0, 0, ""+PstAreaType.fieldNames[PstAreaType.FLD_CHANEL_ID]+"='"+chanel.getOID()+"'", "");
		    if(listGroup.size() > 0){
			content+=""
			+ "<ul class='dropdown-menu sub-menu' role='menu'>";
			for(int iGroup = 0; iGroup < listGroup.size(); iGroup++){
			    AreaType areaType = (AreaType) listGroup.get(iGroup);
			    String parameter2 = "&"+FrmAreaType.fieldNames[FrmAreaType.FRM_FIELD_AREA_TYPE_ID]+"="+areaType.getOID();
			    content += ""
			    + "<li>"
				+ "<a href='monitor.jsp"+parameter+""+parameter2+"' class='trigger'>"+areaType.getAreaTypeName()+" <span class='right-caret'></span></a>";
				Vector listCategory = PstAreaUsage.list(0, 0, ""+PstAreaUsage.fieldNames[PstAreaUsage.FLD_AREA_TYPE_ID]+"='"+areaType.getOID()+"'", "");
				if(listCategory.size() > 0){
				    content+=""
				    + "<ul class='dropdown-menu sub-menu' role='menu'>";
				    for(int iCategory = 0; iCategory < listCategory.size(); iCategory++){
					AreaUsage areaUsage = (AreaUsage) listCategory.get(iCategory);
					String parameter3 = "&"+FrmAreaUsage.fieldNames[FrmAreaUsage.FRM_FIELD_AREA_USAGE_ID]+"="+areaUsage.getOID();
					content += ""
					+ "<li>"
					    + "<a href='monitor.jsp"+parameter+""+parameter2+""+parameter3+"' class='trigger'>"+areaUsage.getAreaUsageName()+" <span class='right-caret'></span></a>";
					    /*Vector listContent = PstAreaList.list(0, 0, ""+PstAreaList.fieldNames[PstAreaList.FLD_AREA_LIST_USAGE_ID]+"='"+areaUsage.getOID()+"'", "");
					    if(listContent.size() > 0){
						content+=""
						+ "<ul class='dropdown-menu sub-menu' role='menu'>";
						for(int iContent = 0; iContent < listContent.size(); iContent++){
						    AreaList areaList = (AreaList) listContent.get(iContent);
						    String parameter4 = "&"+FrmAreaList.fieldNames[FrmAreaList.FRM_FIELD_AREA_LIST_ID]+"="+areaList.getOID();
						    content += ""
						    + "<li>"
							+ "<a href='monitor.jsp"+parameter+""+parameter2+""+parameter3+""+parameter4+"' class='trigger'>"+areaList.getAreaListName()+" <span class='right-caret'></span></a>";

						    content+=""
						    + "</li>";
						}
						content+=""
						+ "</ul>";
					    }*/
					content+=""
					+ "</li>";
				    }
				    content+=""
				    + "</ul>";
				}
			    content+=""
			    + "</li>";
			}
			content+=""
			+ "</ul>";
		    }
		    content+=""
		    + "</li>";
		}
	    }
	    
	    if(chanelType.getPositionMenu() == PstChanelType.POSITION_TOP_LEFT){
		topLeftHeader = header;
		topLeft = content;
	    }else if(chanelType.getPositionMenu() == PstChanelType.POSITION_TOP_RIGHT){
		topRightHeader = header;
		topRight = content;
	    }else if(chanelType.getPositionMenu() == PstChanelType.POSITION_BOTTOM_LEFT){
		bottomLeftHeader = header;
		bottomLeft = content;
	    }else if(chanelType.getPositionMenu() == PstChanelType.POSITION_BOTTOM_RIGHT){
		bottomRightHeader = header;
		bottomRight = content;
	    }
	}
    }

%>
<header class="main-header">
  <nav class="navbar navbar-static-top">
    <div class="container-fluid">
	<div class="col-md-12">
	<div class="col-xs-5">
	    <div class="navbar-header">
		<a href="javascript:" class="navbar-brand">
		    <b><%= topLeftHeader %></b>
		</a>
	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="navbar-collapse">
	      <ul class="nav navbar-nav">
		<%= topLeft %>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	</div>
	<div class="col-xs-5">
	    <div class="navbar-header">
		<a href="javascript:" class="navbar-brand"><b><%= topRightHeader %></b></a>
	    </div>

	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="navbar-collapse">
	      <ul class="nav navbar-nav">
		<%= topRight %>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	</div>
	
	<div class="col-xs-1 pull-right">
	    <ul class='nav navbar-nav'>
		<li class="dropdown">
		    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <span class="caret"></span></a>
		    <ul class="dropdown-menu" role="menu">
			<li><a href="<%= approot %>/home.jsp"><i class="fa fa-home"></i> Admin</a></li>
			<li><a href="<%= approot %>/monitor-list.jsp"><i class="fa fa-list-alt"></i> Content List</a></li>
			<li><a href="<%= approot %>/report-list-monitor.jsp"><i class="fa fa-list-alt"></i> Report List</a></li>
		    </ul>
		</li>
	    </ul>
	</div>
	<button type="button" class="navbar-toggle collapsed pull-right" data-toggle="collapse" data-target="#navbar-collapse">
	    <i class="fa fa-bars"></i>
	</button>
	</div>
    </div><!-- /.container-fluid -->
  </nav>
</header>