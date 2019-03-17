package com.boiko.app.utils;

import com.boiko.app.data.models.RequestFetalHeartbeat;
import com.boiko.app.data.models.RequestTemp;
import com.boiko.app.data.models.ResponseFetalHeartbeat;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;
import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HelpForGraphics {

    public static Series<?> getPoints(List<ResponseFetalHeartbeat> body) throws ParseException {
        List<DataPoint> dataPoints = new ArrayList<>();

        for (ResponseFetalHeartbeat item : body) {
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(item.getTime());
            try {
                dataPoints.add(new DataPoint(date, Double.parseDouble(String.valueOf(item.getBeatsPerSecond()))));
            } catch (Exception e){
                dataPoints.add(new DataPoint(date, 0));
            }
        }
        return new LineGraphSeries<>(dataPoints.toArray(new DataPoint[body.size()]));
    }

    public static Series<?> getPointsTemp(List<RequestTemp> body) throws ParseException {
        List<DataPoint> dataPoints = new ArrayList<>();

        for (RequestTemp item : body) {
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(item.getTime());
            try {
                dataPoints.add(new DataPoint(date, Double.parseDouble(String.valueOf(item.getTemperature()))));
            } catch (Exception e){
                dataPoints.add(new DataPoint(date, 0));
            }
        }
        return new LineGraphSeries<>(dataPoints.toArray(new DataPoint[body.size()]));
    }

}
