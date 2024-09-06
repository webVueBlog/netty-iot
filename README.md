# 通信协议设计

## 头部帧（Header Frame）

| 字段             | 长度 (字节) | 描述                         |
| ---------------- | ----------- | ---------------------------- |
| 帧头             | 2           | 帧同步头 (0xAA 0xBB)         |
| 帧类型           | 1           | 帧的类型                     |
| 数据长度         | 2           | 数据字段的长度               |
| 经度             | 8           | 经度信息                     |
| 纬度             | 8           | 纬度信息                     |
| 柜子编号         | 16          | 柜子的唯一标识符             |
| 数据             | 可变        | 帧的数据                     |
| 校验和           | 4           | 用于校验数据完整性的值       |

## 帧类型（Frame Types）

### 存放包裹请求帧（PutParcelRequest）

| 字段       | 长度 (字节) | 描述             |
| ---------- | ----------- | ---------------- |
| 用户ID     | 8           | 用户标识符       |
| 存储格号   | 2           | 存储格标识符     |
| 包裹ID     | 16          | 包裹唯一标识符   |

### 取件请求帧（RetrieveParcelRequest）

| 字段       | 长度 (字节) | 描述             |
| ---------- | ----------- | ---------------- |
| 用户ID     | 8           | 用户标识符       |
| 存储格号   | 2           | 存储格标识符     |
| 取件码     | 6           | 取件码           |

### 存放包裹确认帧（PutParcelConfirmation）

| 字段       | 长度 (字节) | 描述             |
| ---------- | ----------- | ---------------- |
| 存储格号   | 2           | 存储格标识符     |
| 包裹ID     | 16          | 包裹唯一标识符   |

### 取件确认帧（RetrieveParcelConfirmation）

| 字段       | 长度 (字节) | 描述             |
| ---------- | ----------- | ---------------- |
| 存储格号   | 2           | 存储格标识符     |
| 包裹ID     | 16          | 包裹唯一标识符   |

### 状态更新帧（StatusUpdate）

| 字段       | 长度 (字节) | 描述           |
| ---------- | ----------- | -------------- |
| 温度       | 4           | 温度值         |
| 湿度       | 4           | 湿度值         |
| 电池状态   | 2           | 电池状态值     |

### 签到帧（SignInFrame）

| 字段       | 长度 (字节) | 描述             |
| ---------- | ----------- | ---------------- |
| 版本信息   | 2           | 协议版本信息     |
| 预留字段   | 4           | 预留字段         |