import java.util.*;

class Solution {

    public static class Music {
        String genre;
        int play;
        int num;

        public Music(String genre, int play, int num) {
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<Music>> genreMusicMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);
            
            genreMusicMap
                .computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new Music(genre, play, i));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalMap.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalMap.get(g2) - genreTotalMap.get(g1));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Music> musics = genreMusicMap.get(genre);

            musics.sort(Comparator
                    .comparingInt((Music m) -> m.play).reversed()
                    .thenComparingInt(m -> m.num)
            );

            for (int i = 0; i < Math.min(2, musics.size()); i++) {
                result.add(musics.get(i).num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
