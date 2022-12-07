package Year2022.day7;

import shared.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day7 {

    static List<Integer> listOfCandidatesDirs = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File    inputFile = new File(Constant.BASE_PATH_2022 + "day7\\input.txt");
            Scanner myReader  = new Scanner(inputFile);

            List<DirectoryDTO> directoryDTOList = new ArrayList<>();

            DirectoryDTO currentDirectory = new DirectoryDTO();
            currentDirectory.dirName = "/";

            directoryDTOList.add(currentDirectory);

            int totalSizePrincipal = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                if (data.isEmpty()) {
                    continue;
                }

                if (data.startsWith("$")) {

                    if (data.contains("$ cd")) {

                        switch (data.replace("$ ", "")) {
                            case "cd .." -> {
                                int tempo = currentDirectory.totalSizeFiles;
                                currentDirectory = currentDirectory.parent;
                                currentDirectory.totalSizeFiles += tempo;
                            }
                            case "cd /" -> currentDirectory = directoryDTOList.get(0);
                            default -> {
                                for (DirectoryDTO dir : currentDirectory.dirs) {
                                    if (dir.dirName.equals(data.replace("$ cd ", ""))) {
                                        currentDirectory = dir;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                } else {
                    if (data.startsWith("dir")) {

                        DirectoryDTO newDirectory = new DirectoryDTO();
                        newDirectory.dirName = data.split("dir ")[1];
                        newDirectory.parent  = currentDirectory;
                        currentDirectory.dirs.add(newDirectory);

                    } else {
                        currentDirectory.files.put(data.split(" ")[1], Integer.valueOf(data.split(" ")[0]));
                        currentDirectory.totalSizeFiles += Integer.parseInt(data.split(" ")[0]);
                        totalSizePrincipal += Integer.parseInt(data.split(" ")[0]);
                    }
                }

            }
            myReader.close();

            directoryDTOList.get(0).totalSizeFiles = totalSizePrincipal;

            int sum = getSumOfDirs(directoryDTOList);

            System.out.println(sum); // 919137 (part 1)

            // ------------------- part 2 -------------------

            int unusedSpace = 70000000 - totalSizePrincipal;

            System.out.println("Unused Space = " + unusedSpace);

            getCandidatesToDelete(unusedSpace, directoryDTOList);

            Collections.sort(listOfCandidatesDirs);

            System.out.println("Dir to delete = " + listOfCandidatesDirs.get(0));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void getCandidatesToDelete(Integer unusedSpace, List<DirectoryDTO> dirs) {
        for (DirectoryDTO dir : dirs) {
            if (unusedSpace + dir.totalSizeFiles >= 30000000) {
                listOfCandidatesDirs.add(dir.totalSizeFiles);
            }
            getCandidatesToDelete(unusedSpace, dir.dirs);
        }
    }

    private static int getSumOfDirs(List<DirectoryDTO> dirs) {
        int sum = 0;
        for (DirectoryDTO dir : dirs) {
            if (dir.totalSizeFiles <= 100000) {
                sum += dir.totalSizeFiles;
            }
            sum += getSumOfDirs(dir.dirs);
        }
        return sum;
    }

    public static class DirectoryDTO {

        private String               dirName;
        private DirectoryDTO         parent;
        private Integer              totalSizeFiles = 0;
        private Map<String, Integer> files          = new HashMap<>();
        private List<DirectoryDTO>   dirs           = new ArrayList<>();

    }

}
