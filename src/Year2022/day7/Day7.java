package Year2022.day7;

import shared.Constant;
import shared.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7 {

    //    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day7\\sample.txt";
    private static final String FILE_NAME = Constant.BASE_PATH_2022 + "day7\\input.txt";

    static List<Integer> listOfCandidatesDirs = new ArrayList<>();

    public static void main(String[] args) {

        List<DirectoryDTO> directoryDTOList = new ArrayList<>();

        DirectoryDTO currentDirectory = new DirectoryDTO();
        currentDirectory.dirName = "/";

        directoryDTOList.add(currentDirectory);

        int totalSizePrincipal = 0;

        List<String> input = InputData.get(FILE_NAME);

        for (String line : input) {

            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("$")) {

                if (line.contains("$ cd")) {

                    switch (line.replace("$ ", "")) {
                        case "cd .." -> {
                            int tempo = currentDirectory.totalSizeFiles;
                            currentDirectory = currentDirectory.parent;
                            currentDirectory.totalSizeFiles += tempo;
                        }
                        case "cd /" -> currentDirectory = directoryDTOList.get(0);
                        default -> {
                            for (DirectoryDTO dir : currentDirectory.dirs) {
                                if (dir.dirName.equals(line.replace("$ cd ", ""))) {
                                    currentDirectory = dir;
                                    break;
                                }
                            }
                        }
                    }
                }

            } else {
                if (line.startsWith("dir")) {

                    DirectoryDTO newDirectory = new DirectoryDTO();
                    newDirectory.dirName = line.split("dir ")[1];
                    newDirectory.parent  = currentDirectory;
                    currentDirectory.dirs.add(newDirectory);

                } else {
                    currentDirectory.files.put(line.split(" ")[1], Integer.valueOf(line.split(" ")[0]));
                    currentDirectory.totalSizeFiles += Integer.parseInt(line.split(" ")[0]);
                    totalSizePrincipal += Integer.parseInt(line.split(" ")[0]);
                }
            }

        }

        directoryDTOList.get(0).totalSizeFiles = totalSizePrincipal;

        int sum = getSumOfDirs(directoryDTOList);

        System.out.println("(Part 1). " + sum);

        // ------------------- part 2 -------------------

        int unusedSpace = 70000000 - totalSizePrincipal;

        System.out.println("Unused Space = " + unusedSpace);

        getCandidatesToDelete(unusedSpace, directoryDTOList);

        Collections.sort(listOfCandidatesDirs);

        System.out.println("(Part 2). Dir to delete = " + listOfCandidatesDirs.get(0));

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

}
