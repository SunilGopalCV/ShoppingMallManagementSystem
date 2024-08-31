package in.ac.jssateb.mallmanagement.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_order")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long shopId;
    private LocalDateTime orderDate;
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;
    
    public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Long customerId, Long shopId, LocalDateTime orderDate, Double totalAmount, List<Item> items) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.shopId = shopId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", shopId=" + shopId + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", items=" + items + "]";
	}
    
    
}
