package com.ethan.test.javabasic.future;

import com.ethan.test.javabasic.future.help.Discount;
import com.ethan.test.javabasic.future.help.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopCompletableFuture {


	static List<ShopCompletableFuture> shops = Arrays.asList(new ShopCompletableFuture("BestPrice"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("LetsSaveBig"),
			new ShopCompletableFuture("MyFavoriteShop"),
			new ShopCompletableFuture("BuyItAll"));

	static Executor executor = Executors.newFixedThreadPool(100, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(false);
			return t;
		}
	});


	static Random random = new Random();

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShopCompletableFuture(String name) {
		this.name = name;
	}

	public double getPrice(String product) {
		return caculatePrice(product);
	}

	public String getPriceString(String product) {
		return String.valueOf(caculatePrice(product));
	}

	public static String getPrice(String product, String name) {
		double price = caculatePrice(product);
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return String.format("%s:%.2f:%s", name, price, code);
	}

	/**
	 * 并行版本
	 *
	 * @param product
	 * @return
	 */
	public static List<String> findPrices(String product) {
//		return shops.stream().map(shop -> shop.getPrice(product, "heihei")).map(Quote::parse)
//				.map(Discount::applyDiscount).collect(Collectors.toList());

		List<CompletableFuture<String>> priceFutures = shops.stream().map(shop ->
				CompletableFuture.supplyAsync(() -> shop.getPrice(product, "heihei"), executor))
				.map(future -> future.thenApply(Quote::parse))
				.map(future -> future.thenCompose(
						quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
				.collect(Collectors.toList());
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public static Stream<CompletableFuture<String>> findPricesSteam(String product) {
		return shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(
						() -> shop.getPrice(product, "heihei"), executor))
				.map(future -> future.thenApply(Quote::parse))
				.map(future -> future.thenCompose(
						quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
	}


	public static void randomDelay() {
		int delay = 500 + random.nextInt(2000);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}


	public Future<Double> getPriceAsync(String product) {
		//会关闭异常？？
		return CompletableFuture.supplyAsync((() -> caculatePrice(product)));
//		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//		new Thread(() -> {
//			try {
//				double price = caculatePrice(product);
//				//终端会阻塞异常
//				System.out.println(0 / 0);
//				futurePrice.complete(price);
//
//			} catch (Exception e) {
//				//抛出异常并且结束调用
//				futurePrice.completeExceptionally(e);
//				//throw new RuntimeException(e);
//			}
//		}).start();
//		return futurePrice;
	}


	public static List<String> findPrices(List<ShopCompletableFuture> shops, String product) {
//		return shops.parallelStream().map(shop ->
//				String.format("%s price is %.2f",
//						shop.getName(), shop.getPrice(product))).collect(Collectors.toList());


		List<CompletableFuture<String>> futureList = shops.stream().map(shop -> CompletableFuture.supplyAsync(
				() -> shop.getName() + " price is " + shop.getPrice(product), executor))
				.collect(Collectors.toList());

		return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());


	}

	public static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static double caculatePrice(String product) {
//		delay();
//		System.out.println(0 / 0);
		randomDelay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void main(String[] args) {
//		System.out.println("-->" + Runtime.getRuntime().availableProcessors());
//		ShopFuture shop = new ShopFuture("bestShop");
//		long start = System.nanoTime();
//		Future<Double> futurePrice = shop.getPriceAsync("my love product");
//
//		long invocationTime = (System.nanoTime() - start) / 1_000_000;
//		System.out.println("Invocation returned after " + invocationTime + " msecs");
//		try {
//			System.out.println(futurePrice.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		invocationTime = (System.nanoTime() - start) / 1_000_000;
//
//		System.out.println("Invocation returned after " + invocationTime + " msecs");
//
//

//
//
//		start = System.nanoTime();
//		System.out.println(findPrices(shops, "myphone27"));
//		long duration = (System.nanoTime() - start) / 1_000_000;
//		System.out.println("Done in " + duration + " msecs");
//
//		System.out.println(getPrice("11","22"));


		long start = System.nanoTime();
//		System.out.println(findPrices("heihei"));
		CompletableFuture[] futures = findPricesSteam("hello")
				.map(f -> f.thenAccept(s -> System.out.println(s + " (done in " +
						((System.nanoTime() - start) / 1_000_000) + " msecs)")))
				.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures).join();
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");


	}

}
