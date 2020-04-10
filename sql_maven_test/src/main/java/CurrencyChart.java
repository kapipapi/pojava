import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class CurrencyChart extends ApplicationFrame implements MouseMotionListener {
    CurrencyChart(String title, ArrayList<Record> records) {
        super(title);
        final XYDataset dataset = createDataset(records);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Waluty w czasie",
                "Data",
                "Wartość w PLN",
                dataset, true, false, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(ArrayList<Record> records) {
        TimeSeriesCollection dataset = new TimeSeriesCollection();

        TimeSeries USD_series = new TimeSeries("USD");
        TimeSeries EUR_series = new TimeSeries("EUR");
        TimeSeries GBP_series = new TimeSeries("GBP");
        for (Record r : records) {
            USD_series.add(r.date, r.USD);
            EUR_series.add(r.date, r.EUR);
            GBP_series.add(r.date, r.GBP);
        }
        dataset.addSeries(USD_series);
        dataset.addSeries(EUR_series);
        dataset.addSeries(GBP_series);

        return dataset;
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX());
    }
}
