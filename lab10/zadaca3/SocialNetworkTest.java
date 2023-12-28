package zadaca3;

import java.util.*;

class SocialNetwork {
    private final Map<String, List<String>> adjacencyList;

    public SocialNetwork() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String user, List<String> friends) {
        adjacencyList.put(user, friends);
    }

    public int getShortestPathLength(String startUser, String endUser) {
        if (!adjacencyList.containsKey(startUser) || !adjacencyList.containsKey(endUser)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startUser);
        visited.add(startUser);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentUser = queue.poll();

                if (currentUser.equals(endUser)) {
                    return level;
                }

                List<String> friends = adjacencyList.get(currentUser);

                if (friends != null) {
                    for (String friend : friends) {
                        if (!visited.contains(friend)) {
                            queue.add(friend);
                            visited.add(friend);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
}

public class SocialNetworkTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numUsers = scanner.nextInt();
        scanner.nextLine();

        SocialNetwork socialNetwork = new SocialNetwork();

        for (int i = 0; i < numUsers; i++) {
            String userName = scanner.nextLine();
            int numFriends = scanner.nextInt();
            scanner.nextLine();

            List<String> friends = new ArrayList<>();

            for (int j = 0; j < numFriends; j++) {
                friends.add(scanner.nextLine());
            }

            socialNetwork.addEdge(userName, friends);
        }

        String startUser = scanner.nextLine();
        String endUser = scanner.nextLine();

        int shortestPathLength = socialNetwork.getShortestPathLength(startUser, endUser);

        if (shortestPathLength != -1) {
            System.out.println(shortestPathLength);
        }
    }
}
