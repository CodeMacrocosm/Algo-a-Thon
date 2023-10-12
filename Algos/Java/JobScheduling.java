import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
    static class jobNode {
        public Job job;
        public int maxEnd, height;
        public jobNode left, right;

        public jobNode(Job job, int max) {
            this.job = job;
            this.height = 1;
            this.maxEnd = max;
        }

        public jobNode(Job job) {
            this.job = job;
            this.height = 1;
        }
    }

    public static int height(jobNode x) {
        if (x == null) {
            return 0;
        }

        return x.height;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static jobNode rightRotate(jobNode y) {
        jobNode x = y.left;
        jobNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static jobNode leftRotate(jobNode x) {
        jobNode y = x.right;
        jobNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static int getBalance(jobNode x) {
        if (x == null)
            return 0;

        return height(x.left) - height(x.right);
    }

    public static jobNode insert(jobNode root, Job job) {

        if (root == null)
            return (new jobNode(job, job.end));

        if (job.start < root.job.start) {
            root.left = insert(root.left, job);
        } else if (job.start > root.job.start) {
            root.right = insert(root.right, job);
        } else {
            return root;
        }

        root.height = 1 + max(height(root.left),
                height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && job.start < root.left.job.start)
            return rightRotate(root);

        if (balance < -1 && job.start > root.right.job.start)
            return leftRotate(root);

        if (balance > 1 && job.start > root.left.job.start) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && job.start < root.right.job.start) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static boolean doOverlap(Job A, Job B) {
        if (A.start < B.end && B.start < A.end)
            return true;

        return false;
    }

    static Job overlapSearch(jobNode root,
            Job job) {

        if (root == null)
            return null;

        if (doOverlap(root.job, job))
            return root.job;

        if (root.left != null &&
                root.left.maxEnd >= job.start)
            return overlapSearch(root.left, job);

        return overlapSearch(root.right, job);
    }

    static void findConflicts(Job jobs[]) {

        jobNode root = null;
        root = insert(root, jobs[0]);

        for (int i = 1; i < jobs.length; i++) {

            Job res = overlapSearch(root, jobs[i]);

            if (res != null) {
                res.conflicts++;
                jobs[i].conflicts++;
            }

            root = insert(root, jobs[i]);
        }
    }

    public static jobNode buildTree(Job[] jobs) {
        jobNode tree = new jobNode(jobs[0]);
        for (int i = 1; i < jobs.length; i++) {
            tree = insert(tree, jobs[i]);
        }
        return tree;
    }

    public static Job minConflict(Job[] jobs) {
        Job minJob = new Job(0, 0);
        minJob.conflicts = Integer.MAX_VALUE;
        for (int i = 0; i < jobs.length; i++) {
            if (minJob.conflicts > jobs[i].conflicts) {
                minJob = jobs[i];
            }
        }
        return minJob;
    }

    public static Job maxConflict(Job[] jobs) {
        Job maxJob = new Job(0, 0);
        maxJob.conflicts = Integer.MIN_VALUE;
        for (int i = 0; i < jobs.length; i++) {
            if (maxJob.conflicts < jobs[i].conflicts) {
                maxJob = jobs[i];
            }
        }
        return maxJob;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[] {
                new Job(11, 13),
                new Job(12, 30),
                new Job(41, 52),
                new Job(1, 13),
                new Job(2, 12),
                new Job(1, 6),
                new Job(105, 131),
                new Job(2, 12),
                new Job(14, 63)

        };

        Job[] answer = Job.optimumSchedule(jobs);
        System.out.println();
        System.out.println();
        findConflicts(jobs);
        System.out.println(maxConflict(jobs).start + " " + maxConflict(jobs).end);
        System.out.println(minConflict(jobs).start + " " + minConflict(jobs).end);
        Job.printSchedule(answer);

    }

}

class Job {
    public int start;
    public int end;
    public int conflicts;

    Job(int startTime, int endTime) {
        this.start = startTime;
        this.end = endTime;
    }

    public static Job[] optimumSchedule(Job[] jobs) {
        Job[] optimumJobs = new Job[jobs.length];
        Arrays.sort(jobs, 0, jobs.length, new CompareEndTime());
        int optimumIter = 0;
        optimumJobs[optimumIter++] = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            if (optimumJobs[optimumIter - 1].end <= jobs[i].start) {
                optimumJobs[optimumIter++] = jobs[i];
            }
        }
        return optimumJobs;
    }

    public static void printSchedule(Job[] jobs) {
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i] == null) {
                break;
            }
            System.out.print(
                    "\nStart : " + jobs[i].start + " End : " + jobs[i].end + " Conflicts : " + jobs[i].conflicts);
        }
    }

}

class CompareEndTime implements Comparator<Job> {
    @Override
    public int compare(Job A, Job B) {
        return Integer.compare(A.end, B.end);
    }

}
