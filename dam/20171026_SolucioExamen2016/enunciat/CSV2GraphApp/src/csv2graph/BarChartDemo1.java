package csv2graph;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a bar chart.
 */
public class BarChartDemo1 extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    static {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow",
                true));
    }

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public BarChartDemo1( String titleX, String titleY, String subtitle, String CSVFileRelativePath)  throws Exception{
        super(titleX);
        CategoryDataset dataset = createDataset(CSVFileRelativePath);
        JFreeChart chart = createChart(dataset,  titleX,  titleY,  subtitle);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset(String fileRelativePath) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Reader in = new FileReader(fileRelativePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        
        
        //Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);

        
        for (CSVRecord record : records) {
            String municipi = record.get(0);
            String provincia = record.get(1);
            String poblacioS = record.get(2);
            
            int poblacio = Integer.parseInt(poblacioS);
            //System.out.println(">"+municipi+";"+provincia+";"+poblacioS);
            dataset.addValue(poblacio, municipi, provincia);
        }
         
        return dataset;
    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset, String titleX, String titleY, String subtitle) {
        JFreeChart chart = ChartFactory.createBarChart(
                titleX, null /* x-axis label*/, 
                titleY /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle(subtitle));
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args)  throws Exception{
        if(args.length!=4) {
            System.err.println("ERROR: Invalid command sintax. Usage:");
            System.out.println("\"[relative_path_to_csv]\" \"title X axis\" \"title Y axis\" \"subtitle\"");
            System.out.println("Your input has "+args.length+"parameters :"+Arrays.toString(args));
            
            System.exit(1);
        }
        String CSVRelativePath = args[0];
        String titleX=args[1];
        String titleY = args[2];
        String subtitle = args[3];
        
        System.out.println("CSV Relative Path:"+CSVRelativePath);
        System.out.println("title X:"+titleX);
        System.out.println("title Y:"+titleY);
        System.out.println("subtitle:"+subtitle);
        System.out.println("--------------------------------------------------");
        BarChartDemo1 demo = new BarChartDemo1(
                titleX,titleY, subtitle,
                CSVRelativePath 
        );

        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
