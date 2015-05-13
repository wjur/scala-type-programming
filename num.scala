sealed trait Num {
  type Add[N <: Num] <: Num
}
sealed trait _0 extends Num {
  type Add[N <: Num] = N 
}
sealed trait Succ[N <: Num] extends Num {
  type Add[M <: Num] = Succ[M#Add[N]]
}

type _1 = Succ[_0]
type _2 = Succ[_1]
type _3 = Succ[_2]
type _4 = Succ[_3]
type _5 = Succ[_4]
type _6 = Succ[_5]
type _7 = Succ[_6]

// tests
implicitly[_0#Add[_0] =:= _0]
implicitly[_0#Add[_5] =:= _5]
implicitly[_5#Add[_0] =:= _5]
implicitly[_2#Add[_5] =:= _7]

