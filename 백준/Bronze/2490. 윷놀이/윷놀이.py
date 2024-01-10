for i in range(3):
    sum_list=sum(list(map(int, input().split())))
    if sum_list==0:
        print('D')
    elif sum_list==1:
        print('C')
    elif sum_list==2:
        print('B')
    elif sum_list==3:
        print('A')
    elif sum_list==4:
        print('E')