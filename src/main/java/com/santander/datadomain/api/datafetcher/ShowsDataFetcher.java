package com.santander.datadomain.api.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.santander.datadomain.api.model.Show;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDataFetcher {
    private final List<Show> shows = List.of(
            new Show("Back to the future", 1985),
            new Show("Back to the future II", 1990),
            new Show("Back to the future III", 1995)
    );

    @DgsData(parentType = "Query", field = "shows")
    public List<Show> shows(@InputArgument("titleFilter") String titleFilter) {
        if (titleFilter == null) {
            return shows;
        }
        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
