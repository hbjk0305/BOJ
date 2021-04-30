package Day01.P1713;

import java.util.*;
class Candidate{
    static int createdNum = 0;
    int id, poll, create;
    public Candidate(int id) {
        this.id = id;
        this.poll = 1;
        this.create = createdNum++;
    }
    public void updateCandidate(int id){
        this.id = id;
        this.poll = 1;
        this.create = createdNum++;
    }
}

public class Main {
    static List<Candidate> candidateList = new ArrayList<>();
    static int n, inputNum;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        inputNum = sc.nextInt();
        for (int i=0; i<inputNum; i++){
            int tmp = sc.nextInt();
            pollCandidate(tmp);
        }
        Collections.sort(candidateList, new IdComparator());
        for (Candidate c: candidateList){
            System.out.print(c.id+" ");
        }
    }

    static Candidate findCandidate(int id){
        for (Candidate c: candidateList){
            if (c.id == id) return c;
        }
        return null;
    }
    static void changeMin(int id){
        // 추천수가 가장 작은 학생 -> 가장 오래된 학생
        Candidate min = candidateList.get(0);
        for (int i=1; i<candidateList.size(); i++){
            Candidate now = candidateList.get(i);
            if (min.poll > now.poll){
                min = now;
            }
            else if (min.poll == now.poll){
                if (min.create > now.create) {
                    min = now;
                }
            }
        }
        min.updateCandidate(id);
    }

    static void pollCandidate(int id){
        Candidate candidate = findCandidate(id);
        if (candidate != null){
            candidate.poll ++;
        }
        else{
            candidate = new Candidate(id);
            if (candidateList.size()< n ){
                candidateList.add(candidate);
            }
            else{
                changeMin(id);
            }
        }

    }
}

class IdComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate c1, Candidate c2){
        return Integer.compare(c1.id, c2.id);
    }
}

