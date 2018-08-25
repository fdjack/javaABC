--
-- Created by ZhangYi.
-- User: Administrator
-- Date: 2018/8/24
-- Time: 9:55
--

--local a = 100
--while(true)
--    do
--    a = a-1;
--    if a < 10 then
--        break
--    end
--    print(a)
--    end

--array = { 1, 45, 32, 56213, 6, 7, 21, 7754 }
--
--for index, value in pairs(array) do
--    print(index, value)
--end


function av (a,...)
    local args = { ... }
    result = 0
    for index, v in ipairs(args) do
        result = result + v
    end
    print(a)
    return result / #args
end

print(av(12312,1,2,3,4))

for i = 10,8,-2 do
    print(i)
end

liste = {"abc","倒萨打算","popopo"}

for i  = 1,#liste do
    print(liste[i])
end

print(string.upper("aa"))