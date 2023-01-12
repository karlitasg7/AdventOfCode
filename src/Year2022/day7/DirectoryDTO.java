package Year2022.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryDTO {

    String               dirName;
    DirectoryDTO         parent;
    Integer              totalSizeFiles = 0;
    Map<String, Integer> files          = new HashMap<>();
    List<DirectoryDTO>   dirs           = new ArrayList<>();

}
