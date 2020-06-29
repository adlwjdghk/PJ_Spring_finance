<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);
	
    function drawChart() {

  	 
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Time');
      data.addColumn('number', 'KOSPI');
      data.addColumn('number', 'KOSDAQ');
      data.addColumn('number', 'FUT');

      ${one}.forEach(function(two){ 
          data.addRows([
              [${two.time}, ${two.i_price}, ${two.q_price}, ${two.t_price}]
          ]);
      });

      var options = {
        chart: {
          title: 'Box Office Earnings in First Two Weeks of Opening',
          subtitle: 'in millions of dollars (USD)'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }

 /*    function addValue(){
        data.addRows([
            []
            ]);
        } */
  </script>
</head>
<body>
  <div id="line_top_x"></div>
</body>
</html>