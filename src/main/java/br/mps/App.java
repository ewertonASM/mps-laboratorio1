package br.mps;

import br.mps.infra.ReportGenerator;
import br.mps.view.View;

public class App{
    public static void main(String[] args){
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate();
        View app = new View();

        app.run();
    }
}