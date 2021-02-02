package com.webservice.domain.user;

import com.webservice.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
}
