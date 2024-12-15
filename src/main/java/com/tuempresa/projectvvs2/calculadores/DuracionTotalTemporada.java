package com.tuempresa.projectvvs2.calculadores;

import org.openxava.calculators.ICalculator;
import com.tuempresa.projectvvs2.modelo.Episodio;
import java.util.List;

public class DuracionTotalTemporada implements ICalculator {

    private List<Episodio> episodios;

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public Object calculate() throws Exception {
        if (episodios == null || episodios.isEmpty()) {
            return 0;
        }

        int totalDuracion = 0;
        for (Episodio episodio : episodios) {
            totalDuracion += episodio.getDuracion();
        }

        return totalDuracion;
    }
}
