package es.leanmind.cli.presentation;

import es.leanmind.kpi.application.ClientApplication;
import es.leanmind.kpi.domain.queries.FindAllClientsQuery;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import static es.leanmind.cli.presentation.mappers.KpiMappers.toSuspiciousClientsCliResponse;

@ShellComponent
public class KpiController {

    private ClientApplication clientApplication;

    public KpiController(ClientApplication clientApplication) {
        this.clientApplication = clientApplication;
    }

    @ShellMethod
    public String echo(
            @ShellOption String filename
    ) {
        return toSuspiciousClientsCliResponse(clientApplication.findAll(new FindAllClientsQuery(filename)));
    }
}
