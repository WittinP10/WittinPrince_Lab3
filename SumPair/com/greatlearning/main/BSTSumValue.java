package com.greatlearning.main;

import java.util.HashSet;
import java.util.Set;

public class BSTSumValue {

	public static class Node {

		int data;
		Node left, right;

		Node() {
			left = right = null;
		}

	}

	public static Node newNode(int data) {

		Node temp = new Node();

		temp.data = data;

		return temp;
	}

	public static Node insert(Node root, int key) {

		if (root == null) {

			root = newNode(key);
			return root;
		}

		if (key < root.data) {

			root.left = insert(root.left, key);

		} else {

			root.right = insert(root.right, key);

		}

		return root;
	}

	public static boolean findPair(Node root, int sum, Set set) {

		if (root == null) {

			return false;
		}

		else {

			boolean isPresent = findPair(root.left, sum, set);

			if (isPresent) {

				return isPresent;
			}

			if (set.contains(sum - root.data)) {

				System.out.println("Pair exists with value of " + (sum - root.data) + "," + root.data);
				return true;

			} else {

				set.add(root.data);
			}

			return findPair(root.right, sum, set);

		}

	}

	public static void findPairWithSum(Node root, int sum) {

		HashSet<Integer> set = new HashSet<>();

		boolean isPresent = findPair(root, sum, set);

		if (!isPresent) {

			System.out.println("Pair does not exist");
		}

	}

	public static void main(String[] args) {

		int sum = 60;
		Node root = null;

		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);

		findPairWithSum(root, sum);
	}

}
