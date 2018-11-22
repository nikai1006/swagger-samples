/**
 * Copyright 2016 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.swagger.sample.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class User {

  private long id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private int userStatus;
  private Map<Goods, Friend> friends;
  private List<User> family;
  private Friend friend;
  private List<Goods> goodss;
  private Goods goods;
  private ServiceResponse<Goods> sr;
  private List<String> foods;
  private Map<String, String> levels;

  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @XmlElement(name = "firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @XmlElement(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<User> getFamily() {
    return family;
  }

  public void setFamily(List<User> family) {
    this.family = family;
  }

  @XmlElement(name = "lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @XmlElement(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @XmlElement(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @XmlElement(name = "phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @XmlElement(name = "userStatus")
  @ApiModelProperty(value = "User Status", allowableValues = "1-registered,2-active,3-closed")
  public int getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(int userStatus) {
    this.userStatus = userStatus;
  }

  public Map<Goods, Friend> getFriends() {
    return friends;
  }

  public void setFriends(Map<Goods, Friend> friends) {
    this.friends = friends;
  }

  public Friend getFriend() {
    return friend;
  }

  public void setFriend(Friend friend) {
    this.friend = friend;
  }

  public List<Goods> getGoodss() {
    return goodss;
  }

  public void setGoodss(List<Goods> goodss) {
    this.goodss = goodss;
  }

  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  public ServiceResponse<Goods> getSr() {
    return sr;
  }

  public void setSr(ServiceResponse<Goods> sr) {
    this.sr = sr;
  }

  public List<String> getFoods() {
    return foods;
  }

  public void setFoods(List<String> foods) {
    this.foods = foods;
  }

  public Map<String, String> getLevels() {
    return levels;
  }

  public void setLevels(Map<String, String> levels) {
    this.levels = levels;
  }
}