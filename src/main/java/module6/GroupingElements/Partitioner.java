package module6.GroupingElements;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Partitioner {

    public static Map<Boolean, List<Application>> getPartition(List<Application> applications) {
        return applications.stream().collect(Collectors.partitioningBy(Application::isFree));
    }
}

class Application {
    private final String name;
    private final boolean isFree;

    public Application(String name, boolean isFree) {
        this.name = name;
        this.isFree = isFree;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }
}