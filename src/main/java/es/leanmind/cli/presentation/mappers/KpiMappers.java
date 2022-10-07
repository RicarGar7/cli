package es.leanmind.cli.presentation.mappers;

import es.leanmind.kpi.domain.entities.Client;

import java.util.List;

public class KpiMappers {
    public static String toSuspiciousClientsCliResponse(List<Client> collection) {
        List<String> readings = collection
                .stream()
                .map(client -> client
                        .getSuspiciousReadingsKpi()
                        .stream()
                        .map(suspiciousReading ->
                                String.format("| %s              | %s             | %s          | %s \n",
                                        client.key, suspiciousReading.period, suspiciousReading.value, client.getMedian()
                                ))
                        .toList())
                .flatMap(List::stream)
                .toList();
        return (
                "| Client                     | Month                 | Suspicious     | Median\n" +
                        "-------------------------------------------------------------------------------\n" +
                        readings
        )
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "");
    }
}
