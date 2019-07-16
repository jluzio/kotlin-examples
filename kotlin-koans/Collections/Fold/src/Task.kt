// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val allProducts = customers.flatMap { it.orders.flatMap { it.products } }.toSet()
    return customers.fold(allProducts, { currentProducts, consumer ->
        currentProducts.intersect(consumer.orders.flatMap { it.products })
    })
}