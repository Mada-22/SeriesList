package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    private Series series;

    @BeforeEach
    void setUp() {
        series = new Series();
    }

    @Test
    void testCaptureSeriesManually() {
        // Simulate capturing a new series manually (bypassing JOptionPane)
        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesID("S001");
        seriesModel.setSeriesName("Breaking Bad");
        seriesModel.setSeriesAge(16);
        seriesModel.setSeriesNumberOfEpisode("62");

        series.seriesList.add(seriesModel);

        assertEquals(1, series.seriesList.size());
        assertEquals("S001", series.seriesList.getFirst().getSeriesID());
        assertEquals("Breaking Bad", series.seriesList.getFirst().getSeriesName());
        assertEquals(16, series.seriesList.getFirst().getSeriesAge());
        assertEquals("62", series.seriesList.getFirst().getSeriesNumberOfEpisode());
    }

    @Test
    void testSearchSeriesFound() {
        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesID("S002");
        seriesModel.setSeriesName("Game of Thrones");
        seriesModel.setSeriesAge(18);
        seriesModel.setSeriesNumberOfEpisode("73");

        series.seriesList.add(seriesModel);

        boolean found = series.seriesList.stream()
                .anyMatch(s -> s.getSeriesID().equals("S002"));

        assertTrue(found, "Series should be found");
    }

    @Test
    void testSearchSeriesNotFound() {
        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesID("S003");
        seriesModel.setSeriesName("Friends");
        seriesModel.setSeriesAge(13);
        seriesModel.setSeriesNumberOfEpisode("236");

        series.seriesList.add(seriesModel);

        boolean found = series.seriesList.stream()
                .anyMatch(s -> s.getSeriesID().equals("S999"));

        assertFalse(found, "Series should not be found");
    }

    @Test
    void testUpdateSeries() {
        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesID("S004");
        seriesModel.setSeriesName("The Witcher");
        seriesModel.setSeriesAge(18);
        seriesModel.setSeriesNumberOfEpisode("16");

        series.seriesList.add(seriesModel);

        // Update
        seriesModel.setSeriesName("The Witcher Updated");
        seriesModel.setSeriesAge(17);

        assertEquals("The Witcher Updated", series.seriesList.getFirst().getSeriesName());
        assertEquals(17, series.seriesList.getFirst().getSeriesAge());
    }

    @Test
    void testDeleteSeries() {
        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesID("S005");
        seriesModel.setSeriesName("Loki");
        seriesModel.setSeriesAge(12);
        seriesModel.setSeriesNumberOfEpisode("12");

        series.seriesList.add(seriesModel);

        assertEquals(1, series.seriesList.size());

        // Delete series method
        series.seriesList.removeIf(s -> s.getSeriesID().equals("S005"));

        assertEquals(0, series.seriesList.size(), "Series should be deleted");
    }
}