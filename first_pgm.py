import os

def get_friends():
    return ["lokanath","raghu","khasim",34.5,False]

friends = get_friends()
print(friends[1:3])
print(friends[0:4])
friends.append('hanu')
friends.append(123)
print("after addition",friends)
print("length of list",len(friends))
# this is to test commit