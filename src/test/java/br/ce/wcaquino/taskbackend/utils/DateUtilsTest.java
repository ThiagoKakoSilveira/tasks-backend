package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate input = LocalDate.now().plusDays(1);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(input));
    }

    @Test
    public void deveRetornarFalseParaDatasPassadas() {
        LocalDate input = LocalDate.now().minusDays(1);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(input));
    }

    @Test
    public void deveRetornarTrueParaDataPresente() {
        LocalDate input = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(input));
    }
}